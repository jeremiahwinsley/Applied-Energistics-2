/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2021 TeamAppliedEnergistics
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package appeng.api.storage.data;

import java.util.Collection;

import javax.annotation.Nullable;

import appeng.api.config.FuzzyMode;
import appeng.api.storage.IStorageChannel;

/**
 * Represents a list of items in AE.
 *
 * Don't Implement.
 *
 * Construct with - For items: IAppEngApi.instance().storage().getStorageChannel( ItemStorageChannel.class).createList()
 * - For fluids: IAppEngApi.instance().storage().getStorageChannel( FluidStorageChannel.class).createList() - Replace
 * with the corresponding {@link IStorageChannel} type for non native channels
 */
public interface IAEStackList<T extends IAEStack> extends Iterable<T> {
    /**
     * @return the first item in the list
     */
    @Nullable
    T getFirstItem();

    /**
     * @param i compared item
     * @return a stack equivalent to the stack passed in, but with the correct stack size information, or null if its
     *         not present
     */
    @Nullable
    T findPrecise(T i);

    /**
     * @param input compared item
     * @return a list of relevant fuzzy matched stacks
     */
    Collection<T> findFuzzy(T input, FuzzyMode fuzzy);

    /**
     * @return true if there are no items in the list
     */
    boolean isEmpty();

    /**
     * @return the number of items in the list
     */
    int size();

    /**
     * add a stack to the list, this will merge the stack with an item already in the list if found.
     *
     * @param option added stack
     */
    void add(T option); // adds stack as is

    /**
     * add a stack to the list stackSize is used to add to stackSize, this will merge the stack with an item already in
     * the list if found.
     *
     * @param option stacktype option
     */
    void addStorage(T option); // adds a stack as stored

    /**
     * add a stack to the list as craftable, this will merge the stack with an item already in the list if found.
     *
     * @param option stacktype option
     */
    void addCrafting(T option);

    /**
     * add a stack to the list, stack size is used to add to requestable, this will merge the stack with an item already
     * in the list if found.
     *
     * @param option stacktype option
     */
    void addRequestable(T option); // adds a stack as requestable

    /**
     * resets stack sizes to 0.
     */
    void resetStatus();
}
