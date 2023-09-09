/*
 * Vulnerable Client-Server Application (VuCSA)
 *
 * Copyright (C) 2023 Michal Válka
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <https://www.gnu.org/licenses/>.
 */
package com.warxim.vucsa.server.challenge.rcedeserialization.internal.advanced;

import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Vulnerable class, part of RCE Deserialization challenge
 */
public class ProcessorCommand implements Serializable {
    private final Processor processor;
    private final Object[] args;

    private ProcessorCommand(Processor processor, Object[] args) {
        this.processor = processor;
        this.args = args;
    }

    private void readObject(ObjectInputStream in) throws Exception {
        in.defaultReadObject();

        processor.process(args);
    }
}