package utilities;

import api.payload.User;
import org.testng.Assert;

public class UserAssertions {
    public static void assertUserData(User actualUser, User expectedUser) {
        Assert.assertEquals(actualUser.getName(), expectedUser.getName(), "Name data is not equal");
        Assert.assertEquals(actualUser.getUsername(), expectedUser.getUsername(), "Username data is not equal");
        Assert.assertEquals(actualUser.getEmail(), expectedUser.getEmail(), "Email data is not equal");

        User.Address address = actualUser.getAddress();
        User.Address expectedAddress = expectedUser.getAddress();
        Assert.assertEquals(address.getStreet(), expectedAddress.getStreet(), "Street data is not equal");
        Assert.assertEquals(address.getSuite(), expectedAddress.getSuite(), "Suite data is not equal");
        Assert.assertEquals(address.getCity(), expectedAddress.getCity(), "City data is not equal");
        Assert.assertEquals(address.getZipcode(), expectedAddress.getZipcode(), "Zipcode data is not equal");

        User.Geo geo = address.getGeo();
        User.Geo expectedGeo = expectedAddress.getGeo();
        Assert.assertEquals(geo.getLat(), expectedGeo.getLat(), "Lat data is not equal");
        Assert.assertEquals(geo.getLng(), expectedGeo.getLng(), "Lng data is not equal");

        User.Company company = actualUser.getCompany();
        User.Company expectedCompany = expectedUser.getCompany();
        Assert.assertEquals(company.getName(), expectedCompany.getName(), "Company name data is not equal");
        Assert.assertEquals(company.getCatchPhrase(), expectedCompany.getCatchPhrase(), "CatchPhrase data is not equal");
        Assert.assertEquals(company.getBs(), expectedCompany.getBs(), "Bs data is not equal");
    }
}
