/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.core.util

object RoundRobin {

  def apply[T](values: Array[T]): Iterator[T] = apply(values.toIndexedSeq)

  def apply[T](values: IndexedSeq[T]): Iterator[T] = {
    if (values.isEmpty) Iterator.empty
    else new Iterator[T] {
      private var delegate = values.iterator
      def hasNext = true
      def next = {
        if (delegate.hasNext) delegate.next
        else {
          delegate = values.iterator
          delegate.next
        }
      }
    }

  }
}
