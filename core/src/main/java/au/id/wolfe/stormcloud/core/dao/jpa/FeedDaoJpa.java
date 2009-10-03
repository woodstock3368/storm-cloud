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

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import au.id.wolfe.stormcloud.core.dao.IFeedDao;
import au.id.wolfe.stormcloud.core.model.Feed;

/**
 *
 * Feed data access object which uses JPA.
 *
 */
@Repository("iFeedDao")
@Transactional(readOnly = true)
public class FeedDaoJpa extends GenericDaoJpa<Feed, String> implements IFeedDao{

    /**
     * Constructor that sets the entity to Feed.class.
     */
    public FeedDaoJpa() {
        super(Feed.class);
    }
}
