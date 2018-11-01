/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.connectivity.apache.derby.internal.ui.explorer.providers.virtual;

import org.eclipse.datatools.connectivity.apache.derby.internal.ui.explorer.providers.virtual.SynonymFolder;
import org.eclipse.datatools.connectivity.apache.derby.ui.explorer.providers.virtual.ISynonymFolder;
import org.eclipse.datatools.connectivity.apache.derby.ui.explorer.providers.virtual.IVirtualNodeServiceFactory;

public class NodeFactory implements IVirtualNodeServiceFactory
	{
	    public ISynonymFolder makeSynonymFolder(String name, String displayName, Object parent)
	    {
	        return new SynonymFolder (name, displayName, parent);
	    }
}
