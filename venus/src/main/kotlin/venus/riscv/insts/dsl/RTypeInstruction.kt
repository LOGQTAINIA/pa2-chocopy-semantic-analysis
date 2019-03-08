package venus.riscv.insts.dsl

import venus.riscv.insts.dsl.disasms.RTypeDisassembler
import venus.riscv.insts.dsl.formats.RTypeFormat
import venus.riscv.insts.dsl.impls.NoImplementation
import venus.riscv.insts.dsl.impls.RTypeImplementation32
import venus.riscv.insts.dsl.parsers.RTypeParser

class RTypeInstruction(
        name: String,
        opcode: Int,
        funct3: Int,
        funct7: Int,
        eval32: (Int, Int) -> Int,
        eval64: (Long, Long) -> Long = { _, _ -> throw NotImplementedError("no rv64") }
) : Instruction(
        name = name,
        format = RTypeFormat(opcode, funct3, funct7),
        parser = RTypeParser,
        impl32 = RTypeImplementation32(eval32),
        impl64 = NoImplementation,
        disasm = RTypeDisassembler
)
