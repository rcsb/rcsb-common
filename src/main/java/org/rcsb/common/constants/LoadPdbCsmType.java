package org.rcsb.common.constants;

import java.util.List;

public enum LoadPdbCsmType {

    PDB(ContentType.experimental),
    CSM(ContentType.computational),
    ALL(ContentType.experimental, ContentType.computational);

    private final List<ContentType> contentTypes;
    LoadPdbCsmType(ContentType... contentTypes) {
        this.contentTypes = List.of(contentTypes);
    }

    public List<ContentType> getContentTypes() {
        return contentTypes;
    }

}