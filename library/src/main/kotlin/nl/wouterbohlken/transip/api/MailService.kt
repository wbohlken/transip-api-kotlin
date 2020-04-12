package nl.wouterbohlken.transip.api

import nl.wouterbohlken.transip.client.mail_service.MailServiceClient

class MailService(val token: String) {
  private var mailServiceClient = MailServiceClient(token)

  fun mailService(): MailServiceClient {
    return mailServiceClient
  }
}