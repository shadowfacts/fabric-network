/*
 * Copyright 2016 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabricmc.network.test;

import net.fabricmc.network.AbstractPacket;
import net.minecraft.util.PacketByteBuf;

public class TestPacket extends AbstractPacket {

	private int value;

	public TestPacket(int value) {
		this.value = value;
	}

	public TestPacket() {
	}

	@Override
	public void write(PacketByteBuf buf) {
		buf.writeInt(value);
	}

	@Override
	public void read(PacketByteBuf buf) {
		value = buf.readInt();
	}

	@Override
	public void handle() {
		System.out.println(String.format("Value: %d, Thread: %s", value, Thread.currentThread().getName()));
	}

}
