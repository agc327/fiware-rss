/**
 * Revenue Settlement and Sharing System GE
 * Copyright (C) 2011-2014, Javier Lucio - lucio@tid.es
 * Telefonica Investigacion y Desarrollo, S.A.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * DbeAppProviderApplicationDaoImpl.java
 * 
 * 2013 ®, Telefónica I+D, all rights reserved
 */
package es.tid.fiware.rss.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.tid.fiware.rss.dao.DbeAppProviderApplicationDao;
import es.tid.fiware.rss.model.DbeAppProviderApplication;

/**
 * 
 * 
 */
@Repository
public class DbeAppProviderApplicationDaoImpl extends GenericDaoImpl<DbeAppProviderApplication, String> implements
    DbeAppProviderApplicationDao {

    /**
     * 
     * @param factory
     *            hibernate session factory
     */
    @Autowired
    public DbeAppProviderApplicationDaoImpl(final SessionFactory factory) {
        setSessionFactory(factory);
    }

    /*
     * (non-Javadoc)
     * 
     * @see es.tid.greta.bmms.dao.impl.GenericDaoImpl#getDomainClass()
     */
    @Override
    protected Class<DbeAppProviderApplication> getDomainClass() {
        return DbeAppProviderApplication.class;
    }
}
