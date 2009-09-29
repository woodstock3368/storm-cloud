/**
 * Copyright (C) 2009 Mark Wolfe <mark@wolfe.id.au>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package au.id.wolfe.stormcloud.core.dao;

import au.id.wolfe.stormcloud.core.model.Domain;
import java.util.List;

/**
 *
 * Domain data access object
 *
 */
public interface IDomainDao {

    public List<Domain> getAll();

    public Domain getById(String id);

    public boolean save(Domain domain);

    public boolean delete(Domain domain);

    public boolean update(Domain domain);

}
