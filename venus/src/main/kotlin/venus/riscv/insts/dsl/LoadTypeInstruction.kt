package venus.riscv.insts.dsl

import venus.riscv.insts.dsl.disasms.LoadDisassembler
import venus.riscv.insts.dsl.formats.ITypeFormat
import venus.riscv.insts.dsl.impls.LoadImplementation32
import venus.riscv.insts.dsl.impls.NoImplementation
import venus.riscv.insts.dsl.parsers.LoadParser
import venus.simulator.Simulator

class LoadTypeInstruction(
        name: String,
        opcode: Int,
        funct3: Int,
        load32: (Simulator, Int) -> Int,
        postLoad32: (Int) -> Int = { it },
        load64: (Simulator, Long) -> Long = { _, _ -> throw NotImplementedError("no rv64") },
        postLoad64: (Long) -> Long = { it }
) : Instruction(
        name = name,
        format = ITypeFormat(opcode, funct3),
        parser = LoadParser,
        impl32 = LoadImplementation32(load32, postLoad32),
        impl64 = NoImplementation,
        disasm = LoadDisassembler
)
