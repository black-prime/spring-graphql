/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.graphql.boot.test.tester;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.GraphQlService;
import org.springframework.graphql.boot.GraphQlServiceAutoConfiguration;
import org.springframework.graphql.test.tester.GraphQlTester;

/**
 * Auto-configuration for {@link GraphQlTester}.
 *
 * @author Brian Clozel
 * @since 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({GraphQlTester.class})
@AutoConfigureAfter(value = GraphQlServiceAutoConfiguration.class)
public class GraphQlTesterAutoConfiguration {


	@Bean
	@ConditionalOnBean(GraphQlService.class)
	@ConditionalOnMissingBean
	public GraphQlTester graphQlTester(GraphQlService graphQlService) {
		return GraphQlTester.create(graphQlService);
	}

}
