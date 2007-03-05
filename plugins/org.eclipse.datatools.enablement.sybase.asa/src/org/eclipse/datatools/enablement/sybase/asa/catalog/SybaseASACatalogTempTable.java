/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.enablement.sybase.asa.catalog;

import java.lang.ref.SoftReference;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.datatools.connectivity.sqm.core.rte.ICatalogObject;
import org.eclipse.datatools.connectivity.sqm.core.rte.RefreshManager;
import org.eclipse.datatools.enablement.sybase.asa.baseloaders.SybaseASABaseTempTableLoader;
import org.eclipse.datatools.enablement.sybase.asa.loaders.SybaseASATempTableLoader;
import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.SybaseasabasesqlmodelPackage;
import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.TransactionOption;
import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasasqlmodel.SybaseasasqlmodelPackage;
import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasasqlmodel.impl.SybaseASATempTableImpl;
import org.eclipse.datatools.modelbase.sql.schema.Database;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

public class SybaseASACatalogTempTable extends SybaseASATempTableImpl implements ICatalogObject {
	
	private static final long serialVersionUID = 2055557076455458621L;
	
	protected Boolean columnsLoaded = Boolean.FALSE;
	protected Boolean constraintsLoaded = Boolean.FALSE;
	protected Boolean triggersLoaded = Boolean.FALSE;
	protected Boolean indicesLoaded = Boolean.FALSE;
	protected Boolean tableInfoLoaded = Boolean.FALSE; 
	
	private SoftReference tableLoaderRef = null;
	
	public Database getCatalogDatabase() {
		return this.getSchema().getDatabase();
	}

	public Connection getConnection() {
		return ((ICatalogObject)getCatalogDatabase()).getConnection();
	}

	public void refresh() {
		synchronized (columnsLoaded) {
			if(columnsLoaded.booleanValue())
			{
				columnsLoaded = Boolean.FALSE;
			}
		}
		synchronized (constraintsLoaded) {
			if(constraintsLoaded.booleanValue())
			{
				constraintsLoaded = Boolean.FALSE;
			}
		}
		synchronized (triggersLoaded) {
			if(triggersLoaded.booleanValue())
			{
				triggersLoaded = Boolean.FALSE;
			}
		}
		synchronized (indicesLoaded) {
			if(indicesLoaded.booleanValue())
			{
				indicesLoaded = Boolean.FALSE;
			}
		}
		synchronized (tableInfoLoaded) {
			if(tableInfoLoaded.booleanValue())
			{
				tableInfoLoaded = Boolean.FALSE;
			}
		}
		RefreshManager.getInstance().referesh(this);
	}
	
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch(eDerivedStructuralFeatureID(eFeature))
		{
		case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_TABLE__COLUMNS:
			this.getColumns();
			break;
		case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_TABLE__CONSTRAINTS:
			this.getConstraints();
			break;
		case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_TABLE__TRIGGERS:
			this.getTriggers();
			break;
		case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_TABLE__INDEX:
			this.getIndex();
			break;
		case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_TABLE__DESCRIPTION:
			this.getDescription();
			break;
		case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_TEMP_TABLE__TRANSACTION_OPTION:
			this.getTransactionOption();
			break;
		case SybaseasasqlmodelPackage.SYBASE_ASA_TEMP_TABLE__PCTFREE:
			this.getPctfree();
			break;
		}
		
		return super.eIsSet(eFeature);
	}	

	protected SybaseASABaseTempTableLoader getTableLoader()
	{
		SybaseASABaseTempTableLoader loader = tableLoaderRef == null ? null
				: (SybaseASABaseTempTableLoader) tableLoaderRef.get();
		
		if(loader == null)
		{
			loader = createTableLoader();
			tableLoaderRef = new SoftReference(loader);
		}
		
		return loader;
	}
	
	public EList getColumns() {
		synchronized (columnsLoaded) {
			if(!columnsLoaded.booleanValue())
			{
				getTableLoader().loadColumns(super.getColumns());
				columnsLoaded = Boolean.TRUE;
			}
		}
		return super.getColumns();
	}

	public EList getConstraints() {
		synchronized (constraintsLoaded) {
			if(!constraintsLoaded.booleanValue())
			{
				List existingConstraints = new ArrayList(super.getConstraints().size());
				existingConstraints.addAll(super.getConstraints());
				getTableLoader().loadConstraints(super.getConstraints());
				constraintsLoaded = Boolean.TRUE;
			}
		}
		return super.getConstraints();
	}

	public EList getTriggers() {
		synchronized (triggersLoaded) {
			if(!triggersLoaded.booleanValue())
			{
				getTableLoader().loadTriggers(super.getTriggers());
				triggersLoaded = Boolean.TRUE;
			}
		}
		return super.getTriggers();
	}

	public EList getIndex() {
		synchronized (indicesLoaded) {
			if(!indicesLoaded.booleanValue())
			{
				getTableLoader().loadIndices(super.getIndex());
				indicesLoaded = Boolean.TRUE;
			}
		}
		return super.getIndex();
	}

	public String getDescription() {
		synchronized (tableInfoLoaded) {
			if(!tableInfoLoaded.booleanValue())
			{
				getTableLoader().loadTableInfo();
				tableInfoLoaded = Boolean.TRUE;
			}
		}
		return super.getDescription();
	}

	public TransactionOption getTransactionOption() {
		synchronized (tableInfoLoaded) {
			if(!tableInfoLoaded.booleanValue())
			{
				getTableLoader().loadTableInfo();
				tableInfoLoaded = Boolean.TRUE;
			}
		}
		return super.getTransactionOption();
	}

	public int getPctfree() {
		synchronized (tableInfoLoaded) {
			if(!tableInfoLoaded.booleanValue())
			{
				getTableLoader().loadTableInfo();
				tableInfoLoaded = Boolean.TRUE;
			}
		}
		return super.getPctfree();
	}

	protected SybaseASATempTableLoader createTableLoader()
	{
		return new SybaseASATempTableLoader(this);
	}

}
