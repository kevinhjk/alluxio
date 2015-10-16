/*
 * Licensed to the University of California, Berkeley under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package tachyon.master.file.journal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import tachyon.master.journal.JournalEntry;
import tachyon.master.journal.JournalEntryType;

public class DeleteFileEntry extends JournalEntry {
  public final long mFileId;
  public final boolean mRecursive;
  public final long mOpTimeMs;

  @JsonCreator
  public DeleteFileEntry(@JsonProperty("fileId") long fileId,
      @JsonProperty("recursive") boolean recursive,
      @JsonProperty("operationTimeMs") long opTimeMs) {
    mFileId = fileId;
    mRecursive = recursive;
    mOpTimeMs = opTimeMs;
  }

  @Override
  public JournalEntryType getType() {
    return JournalEntryType.DELETE_FILE;
  }

  @JsonGetter
  public long getFileId() {
    return mFileId;
  }

  @JsonGetter
  public boolean getRecursive() {
    return mRecursive;
  }

  @JsonGetter("operationTimeMs")
  public long getOpTimeMs() {
    return mOpTimeMs;
  }
}
