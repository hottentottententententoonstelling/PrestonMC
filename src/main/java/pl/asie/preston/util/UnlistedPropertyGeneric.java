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

import net.minecraftforge.common.property.IUnlistedProperty;

public class UnlistedPropertyGeneric<T> implements IUnlistedProperty<T> {
    private final String name;
    private final Class<T> klazz;

    public UnlistedPropertyGeneric(String name, Class<T> klazz) {
        this.name = name;
        this.klazz = klazz;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isValid(T value) {
        return true;
    }

    @Override
    public Class<T> getType() {
        return klazz;
    }

    @Override
    public String valueToString(T value) {
        return value != null ? value.toString() : "null";
    }
}
