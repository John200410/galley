package org.commonjava.maven.galley.maven.view;

import java.util.HashMap;
import java.util.Map;

import org.commonjava.maven.atlas.ident.ref.ProjectRef;
import org.commonjava.maven.galley.model.Location;
import org.w3c.dom.Document;

public final class DocRef<T extends ProjectRef>
{

    private final Document doc;

    private final T ref;

    private final Location location;

    private final Map<String, Object> attributes = new HashMap<>();

    public DocRef( final T ref, final Location location, final Document doc )
    {
        this.ref = ref;
        this.location = location;
        this.doc = doc;
    }

    public Document getDoc()
    {
        return doc;
    }

    public T getRef()
    {
        return ref;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setAttribute( final String key, final Object value )
    {
        attributes.put( key, value );
    }

    public <C> C getAttribute( final String key, final Class<C> type )
    {
        final Object val = attributes.get( key );
        return val == null ? null : type.cast( val );
    }

}
