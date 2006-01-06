/***********************************************************************************************************************
 * Copyright (c) 2005 Sybase, Inc. All rights reserved. This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sybase, Inc. - initial API and implementation
 **********************************************************************************************************************/
package org.eclipse.datatools.sqltools.sqleditor;


/**
 * This interface defines all public constants for the SQL Editor plug-in.
 * @author Hui Cao
 */

public interface EditorConstants
{
	/**
	 * Marker type contant for SQL portability targets.
	 */
    public static final String PORTABILITY_MARKER_TYPE = SQLEditorPlugin.PLUGIN_ID + ".portabilitytask";           //$NON-NLS-1$
    /**
     * Marker type contant for SQL syntax errors.
     */
    public static final String SYNTAX_MARKER_TYPE      = SQLEditorPlugin.PLUGIN_ID + ".syntaxproblem";             //$NON-NLS-1$
    
    /**
     * Data source explorer view id
     */
	public static String DATA_SOURCE_EXPLORER = "org.eclipse.datatools.connectivity.DataSourceExplorerNavigator";
	
	/**
	 * Results view id
	 */
	public static String RESULTS_VIEW = "org.eclipse.datatools.sqltools.result.resultView";
	
	/**
	 * Error Log view id
	 */
	public static String LOG_VIEW = "org.eclipse.pde.runtime.LogView";
	
}