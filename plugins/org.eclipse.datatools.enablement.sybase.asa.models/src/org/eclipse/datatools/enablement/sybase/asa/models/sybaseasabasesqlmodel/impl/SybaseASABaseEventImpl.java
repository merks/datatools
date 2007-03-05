/**
 * <copyright>
 * </copyright>
 *
 * $Id: SybaseASABaseEventImpl.java,v 1.4 2007/02/28 01:02:32 hcao Exp $
 */
package org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.impl;

import java.util.Collection;

import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.EventLocationType;
import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.EventType;
import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.Schedule;
import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.SybaseASABaseEvent;
import org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.SybaseasabasesqlmodelPackage;
import org.eclipse.datatools.modelbase.sql.schema.Schema;
import org.eclipse.datatools.modelbase.sql.schema.impl.EventImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sybase ASA Base Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.impl.SybaseASABaseEventImpl#getEventType <em>Event Type</em>}</li>
 *   <li>{@link org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.impl.SybaseASABaseEventImpl#getEventCreator <em>Event Creator</em>}</li>
 *   <li>{@link org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.impl.SybaseASABaseEventImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.datatools.enablement.sybase.asa.models.sybaseasabasesqlmodel.impl.SybaseASABaseEventImpl#getSchedules <em>Schedules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SybaseASABaseEventImpl extends EventImpl implements SybaseASABaseEvent 
{
    /**
     * The default value of the '{@link #getEventType() <em>Event Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEventType()
     * @generated
     * @ordered
     */
	protected static final EventType EVENT_TYPE_EDEFAULT = EventType.NOEVENTTYPE_LITERAL;

    /**
     * The cached value of the '{@link #getEventType() <em>Event Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEventType()
     * @generated
     * @ordered
     */
	protected EventType eventType = EVENT_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getEventCreator() <em>Event Creator</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getEventCreator()
     * @generated
     * @ordered
     */
	protected Schema eventCreator = null;

    /**
     * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLocation()
     * @generated
     * @ordered
     */
	protected static final EventLocationType LOCATION_EDEFAULT = EventLocationType.CONSOLIDATED_LITERAL;

    /**
     * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLocation()
     * @generated
     * @ordered
     */
	protected EventLocationType location = LOCATION_EDEFAULT;

    /**
     * The cached value of the '{@link #getSchedules() <em>Schedules</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSchedules()
     * @generated
     * @ordered
     */
	protected EList schedules = null;

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SybaseASABaseEventImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected EClass eStaticClass()
    {
        return SybaseasabasesqlmodelPackage.Literals.SYBASE_ASA_BASE_EVENT;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EventType getEventType()
    {
        return eventType;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEventType(EventType newEventType)
    {
        EventType oldEventType = eventType;
        eventType = newEventType == null ? EVENT_TYPE_EDEFAULT : newEventType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__EVENT_TYPE, oldEventType, eventType));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Schema getEventCreator()
    {
        if (eventCreator != null && eventCreator.eIsProxy())
        {
            InternalEObject oldEventCreator = (InternalEObject)eventCreator;
            eventCreator = (Schema)eResolveProxy(oldEventCreator);
            if (eventCreator != oldEventCreator)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__EVENT_CREATOR, oldEventCreator, eventCreator));
            }
        }
        return eventCreator;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Schema basicGetEventCreator()
    {
        return eventCreator;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setEventCreator(Schema newEventCreator)
    {
        Schema oldEventCreator = eventCreator;
        eventCreator = newEventCreator;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__EVENT_CREATOR, oldEventCreator, eventCreator));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EventLocationType getLocation()
    {
        return location;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLocation(EventLocationType newLocation)
    {
        EventLocationType oldLocation = location;
        location = newLocation == null ? LOCATION_EDEFAULT : newLocation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__LOCATION, oldLocation, location));
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getSchedules()
    {
        if (schedules == null)
        {
            schedules = new EObjectContainmentWithInverseEList(Schedule.class, this, SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__SCHEDULES, SybaseasabasesqlmodelPackage.SCHEDULE__EVENT);
        }
        return schedules;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__SCHEDULES:
                return ((InternalEList)getSchedules()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
    {
        switch (featureID)
        {
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__SCHEDULES:
                return ((InternalEList)getSchedules()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType)
    {
        switch (featureID)
        {
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__EVENT_TYPE:
                return getEventType();
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__EVENT_CREATOR:
                if (resolve) return getEventCreator();
                return basicGetEventCreator();
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__LOCATION:
                return getLocation();
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__SCHEDULES:
                return getSchedules();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eSet(int featureID, Object newValue)
    {
        switch (featureID)
        {
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__EVENT_TYPE:
                setEventType((EventType)newValue);
                return;
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__EVENT_CREATOR:
                setEventCreator((Schema)newValue);
                return;
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__LOCATION:
                setLocation((EventLocationType)newValue);
                return;
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__SCHEDULES:
                getSchedules().clear();
                getSchedules().addAll((Collection)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eUnset(int featureID)
    {
        switch (featureID)
        {
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__EVENT_TYPE:
                setEventType(EVENT_TYPE_EDEFAULT);
                return;
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__EVENT_CREATOR:
                setEventCreator((Schema)null);
                return;
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__LOCATION:
                setLocation(LOCATION_EDEFAULT);
                return;
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__SCHEDULES:
                getSchedules().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean eIsSet(int featureID)
    {
        switch (featureID)
        {
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__EVENT_TYPE:
                return eventType != EVENT_TYPE_EDEFAULT;
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__EVENT_CREATOR:
                return eventCreator != null;
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__LOCATION:
                return location != LOCATION_EDEFAULT;
            case SybaseasabasesqlmodelPackage.SYBASE_ASA_BASE_EVENT__SCHEDULES:
                return schedules != null && !schedules.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String toString()
    {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (eventType: ");
        result.append(eventType);
        result.append(", location: ");
        result.append(location);
        result.append(')');
        return result.toString();
    }

} //SybaseASABaseEventImpl