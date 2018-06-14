/*
 * Copyright 2013 Bazaarvoice, Inc.
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
package com.bazaarvoice.jolt.common.reference;

/**
 * Reference is used by Shiftr when lookup up values from a WalkedPath (list of LiteralPathElements).
 * <p>
 * Ex given a WalkedPath like :
 * WalkedPath : [
 * LiteralPathElement : [ "cdv-Tuna", "Tuna" ],   // This LiteralPathElement would be generated by a match of "cdv-*" and the key "cdv-Tuna"
 * LiteralPahtElement : [ "Delicious" ]
 * ]
 * <p>
 * &,  &0, &(0,0) would all evaluate to "Delicious"
 * &1, &1, &(1,0) would all evaluate to "cdv-Tuna"
 * &(1,1) would evaluate to "Tuna"
 * <p>
 * The "canonical form" is "C(x,y)", where :
 * C : the character used to determine the type of Reference
 * x : pathIndex : which is how far up the walkedPath the look
 * y : keyGroup : where 0 is the whole key, and 1 thru n smaller captured parts of the key
 */
public interface PathAndGroupReference extends PathReference {

    public int getKeyGroup();
}
