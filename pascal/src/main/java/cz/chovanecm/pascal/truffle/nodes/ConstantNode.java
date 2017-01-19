/*
 * Copyright 2017 martin.
 *
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
 */
package cz.chovanecm.pascal.truffle.nodes;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import cz.rank.pj.pascal.Expression;

/**
 *
 * @author martin
 */
public abstract class ConstantNode extends ExpressionNode {

    private final Object value;

    public ConstantNode(Object value) {
        this.value = value;
    }


    @Specialization
    public Object executeGeneric(VirtualFrame frame) {
        return value;
    }
}
