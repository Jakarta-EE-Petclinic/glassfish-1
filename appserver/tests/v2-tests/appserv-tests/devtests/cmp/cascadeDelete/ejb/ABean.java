/*
 * Copyright (c) 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package cascadeDelete;

import javax.ejb.*;
import javax.naming.*;
import java.util.*;

/**
 * Created Dec 23, 2002 12:43:09 PM
 * Code generated by the Forte For Java EJB Builder
 * @author mvatkina
 */


public abstract class ABean implements javax.ejb.EntityBean {
    
    private javax.ejb.EntityContext context;
    LocalBHome bhome;
    LocalCHome chome;
    LocalDHome dhome;

    
    
    /**
     * @see javax.ejb.EntityBean#setEntityContext(javax.ejb.EntityContext)
     */
    public void setEntityContext(javax.ejb.EntityContext aContext) {
        context=aContext;
        try {
            bhome = lookupB();
            chome = lookupC();
            dhome = lookupD();
        } catch (NamingException e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    
    /**
     * @see javax.ejb.EntityBean#ejbActivate()
     */
    public void ejbActivate() {
        
    }
    
    
    /**
     * @see javax.ejb.EntityBean#ejbPassivate()
     */
    public void ejbPassivate() {
        
    }
    
    
    /**
     * @see javax.ejb.EntityBean#ejbRemove()
     */
    public void ejbRemove() {
        System.out.println("Debug: A ejbRemove");
        Collection bs = getBs();
        System.out.println("Bs: " + bs.size());
        System.out.println("Cs: " + getCs().size());
        System.out.println("Ds: " + getDs().size());
        for (java.util.Iterator it = bs.iterator(); it.hasNext();) {
            ((LocalB)it.next()).cascadeDeleteFromA();
        }
        
    }
    
    
    /**
     * @see javax.ejb.EntityBean#unsetEntityContext()
     */
    public void unsetEntityContext() {
        context=null;
    }
    
    
    /**
     * @see javax.ejb.EntityBean#ejbLoad()
     */
    public void ejbLoad() {
        
    }

    
    /**
     * @see javax.ejb.EntityBean#ejbStore()
     */
    public void ejbStore() {
        
    }
    
    public abstract java.lang.Integer getId();
    public abstract void setId(java.lang.Integer id);
    
    public abstract java.lang.String getName();
    public abstract void setName(java.lang.String name);
    
    public abstract java.util.Collection getDs();
    
    public abstract void setDs(java.util.Collection ds);
    
    public abstract java.util.Collection getCs();
    
    public abstract void setCs(java.util.Collection cs);
    
    public abstract java.util.Collection getBs();
    
    public abstract void setBs(java.util.Collection bs);
    
    public java.lang.Integer ejbCreate(java.lang.Integer id, java.lang.String name) throws javax.ejb.CreateException {
        setId(id);
        setName(name);
        return null;
    }
    
    public void ejbPostCreate(java.lang.Integer id, java.lang.String name) throws javax.ejb.CreateException {
    }
    
    public void addAll() {
        try {
            System.out.println("Debug: A addB");
            Collection bs = bhome.findAll();
            getBs().addAll(bs);
            
            System.out.println("Debug: A addC");
            Collection cs = chome.findAll();
            getCs().addAll(cs);
            
            System.out.println("Debug: A addD");
            Collection ds = dhome.findAll();
            getDs().addAll(ds);
            
            System.out.println("Debug: A addOthers");
            for (Iterator it = bs.iterator(); it.hasNext();) {
                LocalB b = (LocalB)it.next();
                Integer pk = b.getId();
                
                System.out.println("Debug: A add to B " + pk);
                LocalC c = chome.findByPrimaryKey(pk);
                b.setC(c);
                int i = pk.intValue() - 1;
                System.out.println("Debug: A find Ds between " + (i*10) + " and " + (i*20));
                ds = dhome.findInRange(new Integer(i*10), new Integer(i*20));

                b.getDs().addAll(ds);
                c.getDs().addAll(ds);
            }
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    private LocalBHome lookupB() throws NamingException {
        System.out.println("Debug: A lookupB");
        Context initial = new InitialContext();
        Object objref = initial.lookup("java:comp/env/ejb/SimpleB");
        return (LocalBHome) objref;
    }
    
    private LocalCHome lookupC() throws NamingException {
        System.out.println("Debug: A lookupC");
        Context initial = new InitialContext();
        Object objref = initial.lookup("java:comp/env/ejb/SimpleC");
        return (LocalCHome) objref;
    }
    
    private LocalDHome lookupD() throws NamingException {
        System.out.println("Debug: A lookupD");
        Context initial = new InitialContext();
        Object objref = initial.lookup("java:comp/env/ejb/SimpleD");
        return (LocalDHome) objref;
    }

}
