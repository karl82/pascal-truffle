package cz.chovanecm.pascal.truffle.nodes.variables;

import com.oracle.truffle.api.dsl.*;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import cz.chovanecm.pascal.exceptions.TypeException;
import cz.chovanecm.pascal.truffle.nodes.ExpressionNode;
import cz.chovanecm.pascal.truffle.nodes.StatementNode;

/**
 * Created by martin on 1/23/17.
 */
@NodeInfo(shortName = "assignment")
//@NodeFields({@NodeField(name = "slot", type=FrameSlot.class)})
@NodeFields({@NodeField(name = "variableName", type = String.class)})
@NodeChildren({@NodeChild(value = "valueNode", type = ExpressionNode.class)})
//@GenerateNodeFactory
public abstract class WriteVariableNode extends StatementNode {

    //public abstract FrameSlot getSlot();
    public abstract String getVariableName();

    @Specialization
    public void writeLong(VirtualFrame frame, long value) throws TypeException {
        //Slow! Better to already know the slot!
        FrameSlot slot = frame.getFrameDescriptor().findFrameSlot(getVariableName());
        if (slot.getKind() != FrameSlotKind.Long) {
            throw new TypeException("Trying to write a long value to variable " + getVariableName());
        }
        frame.setLong(slot, value);
    }

    @Specialization
    public void writeBoolean(VirtualFrame frame, boolean value) throws TypeException {
        FrameSlot slot = frame.getFrameDescriptor().findFrameSlot(getVariableName());
        if (slot.getKind() != FrameSlotKind.Boolean) {
            throw new TypeException("Trying to write a boolean value to variable " + getVariableName());
        }
        frame.setBoolean(slot, value);
    }

    @Specialization
    public void writeDouble(VirtualFrame frame, double value) throws TypeException {
        FrameSlot slot = frame.getFrameDescriptor().findFrameSlot(getVariableName());
        if (slot.getKind() != FrameSlotKind.Double) {
            throw new TypeException("Trying to write a double value to variable " + getVariableName());
        }
        frame.setDouble(slot, value);
    }

    @Specialization
    public void writeString(VirtualFrame frame, String value) throws TypeException {
        FrameSlot slot = frame.getFrameDescriptor().findFrameSlot(getVariableName());
        if (slot.getKind() != FrameSlotKind.Object) {
            throw new TypeException("Trying to write a String value to variable " + getVariableName());
        }
        frame.setObject(slot, value);
    }

}