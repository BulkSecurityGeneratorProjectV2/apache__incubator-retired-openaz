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

package org.openliberty.openaz.pepapi.std;

import java.util.HashSet;
import java.util.Set;

public final class ObligationCriteriaBuilder {

    private Set<ObligationCriterion> criteria = new HashSet<ObligationCriterion>();

    public ObligationCriteriaBuilder matchAttribute(String attributeId) {
        criteria.add(new ObligationAttributeCriterion(attributeId));
        return this;
    }

    public ObligationCriteriaBuilder matchAttributeWithAnyGivenValue(String attributeId, String... values) {
        criteria.add(new ObligationAttributeCriterion(attributeId, values));
        return this;
    }

    public ObligationCriteriaBuilder matchAnyObligationId(String... obligationIds) {
        criteria.add(new ObligationIdCriterion(obligationIds));
        return this;
    }

    public ObligationCriteriaBuilder matchAnyObligation() {
        criteria.add(new MatchAnyCriterion());
        return this;
    }

    public final ObligationCriteria build() {
        return new ObligationCriteria(criteria);
    }
}
