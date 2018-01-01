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

package pl.asie.preston.util;

import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

import java.util.function.Consumer;

public abstract class EnergyWrapper implements ICapabilityProvider, ITickable {
	protected final Consumer<EnergySystem> energySystemConsumer;

	public EnergyWrapper(Consumer<EnergySystem> energySystemConsumer) {
		this.energySystemConsumer = energySystemConsumer;
	}
}
