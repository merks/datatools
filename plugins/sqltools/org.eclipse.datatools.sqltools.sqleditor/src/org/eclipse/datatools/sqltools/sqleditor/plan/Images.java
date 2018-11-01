/*******************************************************************************
 * Copyright (c) 2005 Sybase, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *    Sybase, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.sqleditor.plan;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.datatools.sqltools.sqleditor.internal.SQLEditorPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * Utility class to load images
 * 
 * @author Dafan Yang
 */
public class Images
{
    private static final String         NAME_PREFIX        = "org.eclipse.datatools.sqltools.sqleditor";
    private static final int            NAME_PREFIX_LENGTH = NAME_PREFIX.length();
    private static URL                  _baseURL           = null;
    // The plugin image registry
    private static ImageRegistry        fgImageRegistry    = null;
    private static HashMap              fgAvoidSWTErrorMap = new HashMap();
    static
    {
        String pathSuffix = "icons/";
        _baseURL = SQLEditorPlugin.getDefault().getBundle().getEntry(pathSuffix);
    }

    // Get execution plan
    public static final String          IMG_EXPLAIN_SQL    = NAME_PREFIX + "explain.gif";
    public static final ImageDescriptor DESC_EXPLAIN_SQL       = createManaged(IMG_EXPLAIN_SQL);
    
    /**
     * Returns the image managed under the given key in this registry.
     * 
     * @param key the image's key
     * @return the image managed under the given key
     */
    public static Image get(String key)
    {
        return getImageRegistry().get(key);
    }

    /**
     * Helper method to convert HashMap to ImageRegistry
     * 
     * @return the image registry
     */
    static ImageRegistry getImageRegistry()
    {
        if (fgImageRegistry == null)
        {
            fgImageRegistry = new ImageRegistry();
            for (Iterator iter = fgAvoidSWTErrorMap.keySet().iterator(); iter.hasNext();)
            {
                String key = (String) iter.next();
                fgImageRegistry.put(key, (ImageDescriptor) fgAvoidSWTErrorMap.get(key));
            }
            fgAvoidSWTErrorMap = null;
        }
        return fgImageRegistry;
    }

    private static ImageDescriptor createManaged(String name)
    {
        try
        {
            ImageDescriptor result = ImageDescriptor.createFromURL(makeIconFileURL(name.substring(NAME_PREFIX_LENGTH)));
            fgAvoidSWTErrorMap.put(name, result);
            return result;
        }
        catch (MalformedURLException e)
        {
            return ImageDescriptor.getMissingImageDescriptor();
        }

    }

    private static URL makeIconFileURL(String name) throws MalformedURLException
    {
        if (_baseURL == null)
            throw new MalformedURLException();
        StringBuffer buffer = new StringBuffer();
        buffer.append(name);
        return new URL(_baseURL, buffer.toString());
    }
}
