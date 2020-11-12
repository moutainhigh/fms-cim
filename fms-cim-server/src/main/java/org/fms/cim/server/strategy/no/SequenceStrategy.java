package org.fms.cim.server.strategy.no;

public interface SequenceStrategy {
    public String generateSequenceNo(String condition);
    public String generateSequenceNo(String condition, int size);
}
