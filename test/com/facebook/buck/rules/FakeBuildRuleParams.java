/*
 * Copyright 2013-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.rules;

import com.facebook.buck.model.BuildTarget;
import com.facebook.buck.model.BuildTargetPattern;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

public class FakeBuildRuleParams extends BuildRuleParams {

  public FakeBuildRuleParams(BuildTarget buildTarget) {
    this(buildTarget, /* deps */ ImmutableSortedSet.<BuildRule>of());
  }

  public FakeBuildRuleParams(BuildTarget buildTarget, ImmutableSortedSet<BuildRule> deps) {
    this(buildTarget, deps, /* visibilityPatterns */ ImmutableSet.of(BuildTargetPattern.MATCH_ALL));
  }

  public FakeBuildRuleParams(BuildTarget buildTarget,
      ImmutableSortedSet<BuildRule> deps,
      ImmutableSet<BuildTargetPattern> visibilityPatterns) {
    super(buildTarget,
        deps,
        visibilityPatterns,
        /* pathRelativizer */ Functions.<String>identity(),
        new FakeRuleKeyBuilderFactory());
  }

}