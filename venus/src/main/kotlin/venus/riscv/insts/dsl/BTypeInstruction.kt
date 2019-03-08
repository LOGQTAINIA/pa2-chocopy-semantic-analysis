package venus.riscv.insts.dsl

import venus.riscv.insts.dsl.disasms.BTypeDisassembler
import venus.riscv.insts.dsl.formats.BTypeFormat
import venus.riscv.insts.dsl.impls.BTypeImplementation32
import venus.riscv.insts.dsl.impls.NoImplementation
import venus.riscv.insts.dsl.parsers.BTypeParser

class BTypeInstruction(
        name: String,
        opcode: Int,
        funct3: Int,
        cond32: (Int, Int) -> Boolean,
        cond64: (Long, Long) -> Boolean = { _, _ -> throw NotImplementedError("no rv64") }
) : Instruction(
        name = name,
        format = BTypeFormat(opcode, funct3),
        parser = BTypeParser,
        impl32 = BTypeImplementation32(cond32),
        impl64 = NoImplementation,
        disasm = BTypeDisassembler
)
