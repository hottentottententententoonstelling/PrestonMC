/*
 * Copyright (c) 2015, 2016, 2017 Adrian Siekierka
 *
 * This file is part of Preston.
 *
 * Preston is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Preston is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Preston.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.asie.preston.network;

import net.minecraft.network.INetHandler;
import net.minecraft.network.PacketBuffer;
import pl.asie.preston.machine.TileCompressor;
import pl.asie.preston.util.VeryLargeMachineEnergyStorage;

public class PacketSyncHeadProgress extends PacketTile {
	private TileCompressor compressor;
	private int armProgClient;

	public PacketSyncHeadProgress() {
		super();
	}

	public PacketSyncHeadProgress(TileCompressor tileEntity) {
		super(tileEntity);
		this.compressor = tileEntity;
	}

	@Override
	public void readData(INetHandler handler, PacketBuffer buf) {
		super.readData(handler, buf);
		armProgClient = buf.readUnsignedByte();
	}

	@Override
	public void apply(INetHandler handler) {
		super.apply(handler);
		if (tile instanceof TileCompressor) {
			compressor = (TileCompressor) tile;
			compressor.armProgressClient = armProgClient;
		}
	}

	@Override
	public void writeData(PacketBuffer buf) {
		super.writeData(buf);
		buf.writeByte(compressor.armProgressClient);
	}

	@Override
	public boolean isAsynchronous() {
		return true;
	}
}
