package org.itstack.demo.jvm.instructions.stores.xastore;

import org.itstack.demo.jvm.instructions.base.InstructionNoOperands;
import org.itstack.demo.jvm.rtda.Frame;
import org.itstack.demo.jvm.rtda.OperandStack;
import org.itstack.demo.jvm.rtda.heap.methodarea.Object;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/29
 */
public class IASTORE extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int val = stack.popInt();
        int idx = stack.popInt();
        Object arrRef = stack.popRef();

        checkNotNull(arrRef);
        int[] ints = arrRef.ints();
        checkIndex(ints.length, idx);
        ints[idx] = val;

    }

}
