// Copyright 2021 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.authentication;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.finos.legend.engine.authentication.flows.*;
import org.finos.legend.engine.authentication.flows.H2StaticWithTestUserPasswordFlow;
import org.finos.legend.engine.authentication.provider.AbstractDatabaseAuthenticationFlowProvider;

public final class LegendDefaultDatabaseAuthenticationFlowProvider extends AbstractDatabaseAuthenticationFlowProvider
{
    public LegendDefaultDatabaseAuthenticationFlowProvider()
    {
        FLOWS.forEach(this::registerFlow);
    }

    private static ImmutableList<DatabaseAuthenticationFlow> FLOWS = Lists.immutable.of(
            new H2StaticWithTestUserPasswordFlow(),
            new SnowflakeWithKeyPairFlow(),
            new BigQueryWithGCPApplicationDefaultCredentialsFlow(),
            new SqlServerStaticWithUserPasswordFlow()
    );
}