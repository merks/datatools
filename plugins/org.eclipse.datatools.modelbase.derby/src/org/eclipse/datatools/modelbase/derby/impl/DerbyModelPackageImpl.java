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
package org.eclipse.datatools.modelbase.derby.impl;

import org.eclipse.datatools.modelbase.derby.DerbyModelFactory;
import org.eclipse.datatools.modelbase.derby.DerbyModelPackage;
import org.eclipse.datatools.modelbase.derby.Synonym;

import org.eclipse.datatools.modelbase.sql.accesscontrol.SQLAccessControlPackage;

import org.eclipse.datatools.modelbase.sql.accesscontrol.impl.SQLAccessControlPackageImpl;

import org.eclipse.datatools.modelbase.sql.constraints.SQLConstraintsPackage;

import org.eclipse.datatools.modelbase.sql.constraints.impl.SQLConstraintsPackageImpl;

import org.eclipse.datatools.modelbase.sql.datatypes.SQLDataTypesPackage;

import org.eclipse.datatools.modelbase.sql.datatypes.impl.SQLDataTypesPackageImpl;

import org.eclipse.datatools.modelbase.sql.expressions.SQLExpressionsPackage;

import org.eclipse.datatools.modelbase.sql.expressions.impl.SQLExpressionsPackageImpl;

import org.eclipse.datatools.modelbase.sql.routines.SQLRoutinesPackage;

import org.eclipse.datatools.modelbase.sql.routines.impl.SQLRoutinesPackageImpl;

import org.eclipse.datatools.modelbase.sql.schema.SQLSchemaPackage;

import org.eclipse.datatools.modelbase.sql.schema.impl.SQLSchemaPackageImpl;

import org.eclipse.datatools.modelbase.sql.statements.SQLStatementsPackage;

import org.eclipse.datatools.modelbase.sql.statements.impl.SQLStatementsPackageImpl;

import org.eclipse.datatools.modelbase.sql.tables.SQLTablesPackage;

import org.eclipse.datatools.modelbase.sql.tables.impl.SQLTablesPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DerbyModelPackageImpl extends EPackageImpl implements DerbyModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synonymEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.datatools.modelbase.derby.DerbyModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DerbyModelPackageImpl() {
		super(eNS_URI, DerbyModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DerbyModelPackage init() {
		if (isInited) return (DerbyModelPackage)EPackage.Registry.INSTANCE.getEPackage(DerbyModelPackage.eNS_URI);

		// Obtain or create and register package
		DerbyModelPackageImpl theDerbyModelPackage = (DerbyModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DerbyModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new DerbyModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackageImpl.init();

		// Obtain or create and register interdependencies
		SQLSchemaPackageImpl theSQLSchemaPackage = (SQLSchemaPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SQLSchemaPackage.eNS_URI) instanceof SQLSchemaPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SQLSchemaPackage.eNS_URI) : SQLSchemaPackage.eINSTANCE);
		SQLConstraintsPackageImpl theSQLConstraintsPackage = (SQLConstraintsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SQLConstraintsPackage.eNS_URI) instanceof SQLConstraintsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SQLConstraintsPackage.eNS_URI) : SQLConstraintsPackage.eINSTANCE);
		SQLDataTypesPackageImpl theSQLDataTypesPackage = (SQLDataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SQLDataTypesPackage.eNS_URI) instanceof SQLDataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SQLDataTypesPackage.eNS_URI) : SQLDataTypesPackage.eINSTANCE);
		SQLExpressionsPackageImpl theSQLExpressionsPackage = (SQLExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SQLExpressionsPackage.eNS_URI) instanceof SQLExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SQLExpressionsPackage.eNS_URI) : SQLExpressionsPackage.eINSTANCE);
		SQLRoutinesPackageImpl theSQLRoutinesPackage = (SQLRoutinesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SQLRoutinesPackage.eNS_URI) instanceof SQLRoutinesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SQLRoutinesPackage.eNS_URI) : SQLRoutinesPackage.eINSTANCE);
		SQLStatementsPackageImpl theSQLStatementsPackage = (SQLStatementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SQLStatementsPackage.eNS_URI) instanceof SQLStatementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SQLStatementsPackage.eNS_URI) : SQLStatementsPackage.eINSTANCE);
		SQLTablesPackageImpl theSQLTablesPackage = (SQLTablesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SQLTablesPackage.eNS_URI) instanceof SQLTablesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SQLTablesPackage.eNS_URI) : SQLTablesPackage.eINSTANCE);
		SQLAccessControlPackageImpl theSQLAccessControlPackage = (SQLAccessControlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SQLAccessControlPackage.eNS_URI) instanceof SQLAccessControlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SQLAccessControlPackage.eNS_URI) : SQLAccessControlPackage.eINSTANCE);

		// Create package meta-data objects
		theDerbyModelPackage.createPackageContents();
		theSQLSchemaPackage.createPackageContents();
		theSQLConstraintsPackage.createPackageContents();
		theSQLDataTypesPackage.createPackageContents();
		theSQLExpressionsPackage.createPackageContents();
		theSQLRoutinesPackage.createPackageContents();
		theSQLStatementsPackage.createPackageContents();
		theSQLTablesPackage.createPackageContents();
		theSQLAccessControlPackage.createPackageContents();

		// Initialize created meta-data
		theDerbyModelPackage.initializePackageContents();
		theSQLSchemaPackage.initializePackageContents();
		theSQLConstraintsPackage.initializePackageContents();
		theSQLDataTypesPackage.initializePackageContents();
		theSQLExpressionsPackage.initializePackageContents();
		theSQLRoutinesPackage.initializePackageContents();
		theSQLStatementsPackage.initializePackageContents();
		theSQLTablesPackage.initializePackageContents();
		theSQLAccessControlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDerbyModelPackage.freeze();

		return theDerbyModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSynonym() {
		return synonymEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynonym_Table() {
		return (EReference)synonymEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerbyModelFactory getDerbyModelFactory() {
		return (DerbyModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		synonymEClass = createEClass(SYNONYM);
		createEReference(synonymEClass, SYNONYM__TABLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SQLTablesPackageImpl theSQLTablesPackage = (SQLTablesPackageImpl)EPackage.Registry.INSTANCE.getEPackage(SQLTablesPackage.eNS_URI);
		SQLSchemaPackageImpl theSQLSchemaPackage = (SQLSchemaPackageImpl)EPackage.Registry.INSTANCE.getEPackage(SQLSchemaPackage.eNS_URI);

		// Add supertypes to classes
		synonymEClass.getESuperTypes().add(theSQLTablesPackage.getTable());
		synonymEClass.getESuperTypes().add(theSQLSchemaPackage.getSQLObject());

		// Initialize classes and features; add operations and parameters
		initEClass(synonymEClass, Synonym.class, "Synonym", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSynonym_Table(), theSQLTablesPackage.getTable(), null, "Table", null, 1, 1, Synonym.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //DerbyModelPackageImpl
