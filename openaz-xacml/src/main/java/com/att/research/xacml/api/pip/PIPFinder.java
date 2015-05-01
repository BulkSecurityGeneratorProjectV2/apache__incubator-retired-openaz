/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */

/*
 *                        AT&T - PROPRIETARY
 *          THIS FILE CONTAINS PROPRIETARY INFORMATION OF
 *        AT&T AND IS NOT TO BE DISCLOSED OR USED EXCEPT IN
 *             ACCORDANCE WITH APPLICABLE AGREEMENTS.
 *
 *          Copyright (c) 2013 AT&T Knowledge Ventures
 *              Unpublished and Not for Publication
 *                     All Rights Reserved
 */
package com.att.research.xacml.api.pip;

import java.util.Collection;

/**
 * PIPFinder is the interface objects implement that can query multiple sources of {@link com.att.research.xacml.api.Attribute}s based
 * on a {@link com.att.research.xacml.api.pip.PIPRequest}.
 * 
 * @author car
 * @version $Revision: 1.3 $
 */
public interface PIPFinder {
	/**
	 * Retrieves <code>Attribute</code>s that based on the given {@link com.att.research.xacml.api.pip.PIPRequest}.
	 * The {@link com.att.research.xacml.api.pip.PIPResponse} may contain multiple <code>Attribute</code>s and they
	 * do not need to match the <code>PIPRequest</code>.  In this way, a <code>PIPFinder</code> may compute multiple
	 * related <code>Attribute</code>s at once.
	 * 
	 * @param pipRequest the <code>PIPRequest</code> defining which <code>Attribute</code>s should be retrieved
	 * @param excude the (optional) <code>PIPEngine</code> to exclude from searches for the given <code>PIPRequest</code>
	 * @return a {@link com.att.research.xacml.pip.PIPResponse} with the results of the request
	 * @throws PIPException if there is an error retrieving the <code>Attribute</code>s.
	 */
	public PIPResponse getAttributes(PIPRequest pipRequest, PIPEngine exclude) throws PIPException;
	
	/**
	 * Retrieves <code>Attribute</code>s that match the given {@link com.att.research.xacml.api.pip.PIPRequest}.
	 * The {@link com.att.research.xacml.api.pip.PIPResponse} should only include a single {@link com.att.research.xacml.api.Attribute}
	 * with {@link com.att.research.xacml.api.AttributeValue}s whose data type matches the request.
	 * 
	 * @param pipRequest the <code>PIPRequest</code> defining which <code>Attribute</code>s should be retrieved
	 * @param excude the (optional) <code>PIPEngine</code> to exclude from searches for the given <code>PIPRequest</code>
	 * @return a {@link com.att.research.xacml.pip.PIPResponse} with the results of the request
	 * @throws PIPException if there is an error retrieving the <code>Attribute</code>s.
	 */
	public PIPResponse getMatchingAttributes(PIPRequest pipRequest, PIPEngine exclude) throws PIPException;
	
	/**
	 * Retrieves <code>Attribute</code>s that based on the given <code>PIPRequest</code> as above.  If the
	 * <code>PIPFinder</code> invokes the <code>getAttributes</code> method on any child <code>PIPEngine</code>s,
	 * it should use the supplied <code>PIPFinder</code> rather than itself in the call.
	 * 
	 * @param pipRequest
	 * @param exclude
	 * @param pipFinderParent
	 * @return
	 * @throws PIPException
	 */
	public PIPResponse getAttributes(PIPRequest pipRequest, PIPEngine exclude, PIPFinder pipFinderParent) throws PIPException;
	
	/**
	 * Retrieves <code>Attribute</code>s that match the given <code>PIPRequest</code> as above.  If the
	 * <code>PIPFinder</code> invokes the <code>getAttributes</code> method on any child <code>PIPEngine</code>s,
	 * it should use the supplied <code>PIPFinder</code> rather than itself in the call.
	 * 
	 * @param pipRequest
	 * @param exclude
	 * @param pipFinderParent
	 * @return
	 * @throws PIPException
	 */
	public PIPResponse getMatchingAttributes(PIPRequest pipRequest, PIPEngine exclude, PIPFinder pipFinderParent) throws PIPException;
	
	public Collection<PIPEngine>	getPIPEngines();
}