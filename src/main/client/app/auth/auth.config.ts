interface AuthConfiguration {
    clientID: string,
    domain: string,
    callbackURL: string
}

export const myConfig: AuthConfiguration = {
    clientID: 'CLIENT_ID',
    domain: 'DOMAIN',
    callbackURL: 'CALLBACK_URL'
};