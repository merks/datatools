/*******************************************************************************
 * Copyright (c) 2004, 2005 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.datatools.connectivity.oda.flatfile.tests.csv;

import org.eclipse.datatools.connectivity.oda.flatfile.CommonConstants;
import org.eclipse.datatools.connectivity.oda.flatfile.tests.QueryTestBase;
import org.eclipse.datatools.connectivity.oda.flatfile.tests.TestUtil;

/**
 * Test case for FlatFileQuery implementation under comma CSV
 */

public class QueryTest extends QueryTestBase
{
	/**
	 * 
	 * @throws Exception
	 */
	public QueryTest( ) throws Exception
	{
		super( );
	}

	/**
	 * 
	 */
	protected String getSuffix( )
	{
		return TestUtil.SUFFIX_COMMA;
	}

	/**
	 * 
	 */
	protected String getDelimiter( )
	{
		return CommonConstants.DELIMITER_COMMA_VALUE;
	}
	
	/**
	 * 
	 */
	protected String getDelimiterName( )
	{
		return CommonConstants.DELIMITER_COMMA;
	}

	/**
	 * 
	 */
	protected String getExtension( )
	{
		return TestUtil.CSV_EXTENSION;
	}
}
