package com.felipeteles.desafio2.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleOAuthConstants;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;

public class GmailApiQuickStart {

	// Check https://developers.google.com/gmail/api/auth/scopes for all available scopes
	private static final String SCOPE = "https://www.googleapis.com/auth/gmail.readonly";
	private static final String APP_NAME = "GmailApiQuickStart";
	private static final String USER = "Felipe";
	// Path to the client_secret.json file downloaded from the Developer Console
	private static final String CLIENT_SECRET_PATH = "[ADD URL OF YOUR client_secret.json]";

	private static GoogleClientSecrets clientSecrets;

	public void buscar() throws IOException {
		HttpTransport httpTransport = new NetHttpTransport();
		JsonFactory jsonFactory = new JacksonFactory();
	
		clientSecrets = GoogleClientSecrets.load(jsonFactory,  new FileReader(CLIENT_SECRET_PATH));
	
		// Allow user to authorize via url.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
		    httpTransport, jsonFactory, clientSecrets, Arrays.asList(SCOPE))
		    .setAccessType("online")
		    .setApprovalPrompt("auto").build();
	
		String url = flow.newAuthorizationUrl().setRedirectUri(GoogleOAuthConstants.OOB_REDIRECT_URI)
		    .build();
		System.out.println("Please open the following URL in your browser then type"
		                   + " the authorization code:\n" + url);
	
		// Read code entered by user.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
	
		// Generate Credential using retrieved code.
		GoogleTokenResponse responseT = flow.newTokenRequest(code)
		    .setRedirectUri(GoogleOAuthConstants.OOB_REDIRECT_URI).execute();
		GoogleCredential credential = new GoogleCredential()
		    .setFromTokenResponse(responseT);
	
		// Create a new authorized Gmail API client
		Gmail service = new Gmail.Builder(httpTransport, jsonFactory, credential)
		    .setApplicationName(APP_NAME).build();
	
		ListMessagesResponse response = service.users().messages().list(USER).setQ("vagas").execute();
	
		List<Message> messages = new ArrayList<Message>();
	
		while (response.getMessages() != null) {
		  messages.addAll(response.getMessages());
		  if (response.getNextPageToken() != null) {
		    String pageToken = response.getNextPageToken();
		    response = service.users().messages().list(USER).setQ("vagas")
		        .setPageToken(pageToken).execute();
		  } else {
		    break;
		  }
		}

		for (Message message : messages) {
		    //I dont know to get more informations only id and thread
			//gmail.users.messages.get
			//GET https://www.googleapis.com/gmail/v1/users/YOURMAIL/messages/YOURID?format=full&key={YOUR_API_KEY}

		    System.out.println(message.toPrettyString());
		}
	}
}