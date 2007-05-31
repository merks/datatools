/**
 * <copyright>
 * </copyright>
 *
 * $Id: SybaseASATableImpl.java,v 1.2 2007/03/19 16:37:08 jgraham Exp $
 */
package org.eclipse.datatools.enablement.sybase.asa.models.sybaseasasqlmodel.impl;

import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.impl.SybaseASABaseTableImpl;
import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasasqlmodel.SybaseASATable;
import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasasqlmodel.SybaseasasqlmodelPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sybase ASA Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.datatools.enablement.sybase.asa.models.sybaseasasqlmodel.impl.SybaseASATableImpl#getPctfree <em>Pctfree</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SybaseASATableImpl extends SybaseASABaseTableImpl implements SybaseASATable 
{
	/**
	 * The default value of the '{@link #getPctfree() <em>Pctfree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPctfree()
	 * @generated
	 * @ordered
	 */
	protected static final int PCTFREE_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getPctfree() <em>Pctfree</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPctfree()
	 * @generated
	 * @ordered
	 */
	protected int pctfree = PCTFREE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SybaseASATableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SybaseasasqlmodelPackage.Literals.SYBASE_ASA_TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPctfree() {
		return pctfree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPctfree(int newPctfree) {
		int oldPctfree = pctfree;
		pctfree = newPctfree;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SybaseasasqlmodelPackage.SYBASE_ASA_TABLE__PCTFREE, oldPctfree, pctfree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SybaseasasqlmodelPackage.SYBASE_ASA_TABLE__PCTFREE:
				return new Integer(getPctfree());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SybaseasasqlmodelPackage.SYBASE_ASA_TABLE__PCTFREE:
				setPctfree(((Integer)newValue).intValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case SybaseasasqlmodelPackage.SYBASE_ASA_TABLE__PCTFREE:
				setPctfree(PCTFREE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SybaseasasqlmodelPackage.SYBASE_ASA_TABLE__PCTFREE:
				return pctfree != PCTFREE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (pctfree: ");
		result.append(pctfree);
		result.append(')');
		return result.toString();
	}

} //SybaseASATableImpl