/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdbi.v3.sqlobject;

import java.util.Objects;

import org.jdbi.v3.extension.ExtensionConfig;
import org.jdbi.v3.sqlobject.locator.AnnotationSqlLocator;
import org.jdbi.v3.sqlobject.locator.SqlLocator;

public class SqlObject implements ExtensionConfig<SqlObject> {
    private SqlLocator sqlLocator;

    SqlObject() {
        sqlLocator = new AnnotationSqlLocator();
    }

    SqlObject(SqlObject parent) {
        this.sqlLocator = parent.sqlLocator;
    }

    public SqlLocator getSqlLocator() {
        return sqlLocator;
    }

    public SqlObject setSqlLocator(SqlLocator sqlLocator) {
        this.sqlLocator = Objects.requireNonNull(sqlLocator);
        return this;
    }

    @Override
    public SqlObject createCopy() {
        return new SqlObject(this);
    }
}
