package pl.edu.agh.components;

import org.jinstagram.Instagram;
import org.jinstagram.auth.model.Token;
import org.jinstagram.entity.common.Location;
import org.jinstagram.entity.users.feed.MediaFeedData;
import org.jinstagram.exceptions.InstagramException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lmarek on 16.03.16.
 */
@Component
public class LocationManager {

    public List<Location> searchForLocation(Token token, double latitude, double longitude) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.searchLocation(latitude,longitude).getLocationList();
    }

    public Location getLocationInfo(Token token, String locationId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getLocationInfo(locationId).getLocationData();
    }

    public List<MediaFeedData> searchForMediaInLocation(Token token, String locationId) throws InstagramException {
        Instagram instagram = new Instagram(token);
        return instagram.getRecentMediaByLocation(locationId).getData();
    }
}
