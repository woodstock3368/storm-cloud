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
package au.id.wolfe.stormcloud.core.dao.jpa;

import au.id.wolfe.stormcloud.core.dao.IDomainDao;
import au.id.wolfe.stormcloud.core.model.Domain;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * This class interacts with the JPA Entity Manager to save/delete and
 * retrieve Domain objects.
 * 
 */
@Repository("iDomainDao")
public class DomainDaoJpa extends GenericDaoJpa<Domain, String> implements IDomainDao {

    /**
     * Constructor that sets the entity to Domain.class.
     */
    public DomainDaoJpa() {
        super(Domain.class);
    }

}
