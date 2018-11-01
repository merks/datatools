/***********************************************************************************************************************
 * Copyright (c) 2009 Sybase, Inc. All rights reserved. This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License 2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors: Sybase, Inc. - initial API and implementation
 **********************************************************************************************************************/
package org.eclipse.datatools.enablement.sybase.asa.schemaobjecteditor.examples;

import org.eclipse.datatools.sqltools.core.DataTypeValidator;
import org.eclipse.datatools.sqltools.core.DatabaseVendorDefinitionId;


/**
 * Data type validator for ASA
 * @author Idull
 */
public class ASADataTypeValidator extends DataTypeValidator
{
    protected DatabaseVendorDefinitionId getDatabaseVendorDefinitionId()
    {
        return ASAConfig.getInstance().getDatabaseVendorDefinitionId();
    }
}
