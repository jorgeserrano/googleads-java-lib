// Copyright 2012 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package dfa.axis.v1_19;

import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.dfa.axis.factory.DfaServices;
import com.google.api.ads.dfa.axis.v1_19.LoginRemote;
import com.google.api.ads.dfa.axis.v1_19.UserProfile;
import com.google.api.ads.dfa.lib.client.DfaSession;
import com.google.api.client.auth.oauth2.Credential;

/**
 * This example authenticates using your DFA user name and password, and
 * displays the user profile token, DFA account name and ID. The user profile
 * token along with the user name will be used in all other examples to
 * construct the SOAP headers.
 *
 * Note that using the DFA client library, you can store your credentials in the
 * session object to have the library handle authentication for you.
 *
 * Credentials and properties in {@code fromFile()} are pulled from the
 * "ads.properties" file. See README for more info.
 *
 * Tags: login.authenticate
 *
 * @author Joseph DiLallo
 */
public class Authenticate {

  public static void runExample(DfaServices dfaServices, DfaSession session) throws Exception {
    String username = session.getUsername();
    String password = session.getPassword();

    // Request the login service from the service client factory.
    LoginRemote loginService = dfaServices.get(session, LoginRemote.class);

    // Authenticate.
    UserProfile userProfile = loginService.authenticate(username, password);

    // Display user profile token, DFA account name and ID.
    System.out.printf("User profile token is \"%s\", DFA account name is \"%s\", and DFA " +
        "account ID is \"%s\".%n", userProfile.getToken(), userProfile.getNetworkName(),
        userProfile.getNetworkId());
  }

  public static void main(String[] args) throws Exception {
    // Generate a refreshable OAuth2 credential, which replaces legacy passwords
    // and can be used in place of a service account.
    Credential oAuth2Credential = new OfflineCredentials.Builder()
        .forApi(Api.DFA)
        .fromFile()
        .build()
        .generateCredential();

    // Construct a DfaSession.
    DfaSession session = new DfaSession.Builder()
        .fromFile()
        .withOAuth2Credential(oAuth2Credential)
        .build();

    DfaServices dfaServices = new DfaServices();

    runExample(dfaServices, session);
  }
}
