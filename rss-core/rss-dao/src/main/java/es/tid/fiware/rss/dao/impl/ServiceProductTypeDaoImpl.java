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

package es.tid.fiware.rss.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.tid.fiware.rss.dao.ServiceProductTypeDao;
import es.tid.fiware.rss.model.BmServiceProductType;
import es.tid.fiware.rss.model.BmServiceProductTypeId;

/**
 * 
 * 
 */
@Repository
public class ServiceProductTypeDaoImpl
    extends GenericDaoImpl<BmServiceProductType, BmServiceProductTypeId> implements ServiceProductTypeDao {

    /**
     * Variable to print the trace.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProductTypeDaoImpl.class);

    /**
     * 
     * @param factory
     *            hibernate session factory
     */
    @Autowired
    public ServiceProductTypeDaoImpl(final SessionFactory factory) {
        setSessionFactory(factory);
    }

    /*
     * (non-Javadoc)
     * 
     * @see es.tid.greta.bmms.dao.impl.GenericDaoImpl#getDomainClass()
     */
    @Override
    protected final Class<BmServiceProductType> getDomainClass() {
        return BmServiceProductType.class;
    }

    @Override
    public BmServiceProductType getByDefault(long serviceId) {
        Criteria criteria = getSession().createCriteria(BmServiceProductType.class)
            .add(Restrictions.eq("id.nuServiceId", serviceId)).add(Restrictions.eq("tcIsDefaultYn", "Y"));
        BmServiceProductType result = (BmServiceProductType) criteria.uniqueResult();
        return result;
    }

}
