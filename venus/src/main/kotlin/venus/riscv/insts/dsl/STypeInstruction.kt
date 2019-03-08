package venus.riscv.insts.dsl

import venus.riscv.insts.dsl.disasms.STypeDisassembler
import venus.riscv.insts.dsl.formats.STypeFormat
import venus.riscv.insts.dsl.impls.NoImplementation
import venus.riscv.insts.dsl.impls.STypeImplementation32
import venus.riscv.insts.dsl.parsers.STypeParser
import venus.simulator.Simulator

class STypeInstruction(
        name: String,
        opcode: Int,
        funct3: Int,
        store32: (Simulator, Int, Int) -> Unit,
        store64: (Simulator, Long, Long) -> Unit = { _, _, _ -> throw NotImplementedError("no rv64") }
) : Instruction(
        name = name,
        format = STypeFormat(opcode, funct3),
        parser = STypeParser,
        impl32 = STypeImplementation32(store32),
        impl64 = NoImplementation,
        disasm = STypeDisassembler
)
