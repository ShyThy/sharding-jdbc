/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.rdb.integrate.type.sharding.hint.base;

import com.dangdang.ddframe.rdb.integrate.fixture.HintModuloDatabaseShardingAlgorithm;
import com.dangdang.ddframe.rdb.sharding.api.config.ShardingRuleConfiguration;
import com.dangdang.ddframe.rdb.sharding.api.config.strategy.HintShardingStrategyConfiguration;
import com.dangdang.ddframe.rdb.sharding.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.constant.DatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

public abstract class AbstractRoutingDatabaseOnlyWithHintTest extends AbstractHintTest {
    
    @Override
    protected ShardingRule getShardingRule(final Map.Entry<DatabaseType, Map<String, DataSource>> dataSourceEntry) throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        HintShardingStrategyConfiguration shardingStrategyConfig = new HintShardingStrategyConfiguration();
        shardingStrategyConfig.setAlgorithmClassName(HintModuloDatabaseShardingAlgorithm.class.getName());
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(shardingStrategyConfig);
        return shardingRuleConfig.build(dataSourceEntry.getValue());
    }
}
