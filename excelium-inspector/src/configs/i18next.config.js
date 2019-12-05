import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';
import Backend from 'i18next-xhr-backend';
import LanguageDetector from 'i18next-browser-languagedetector';
import config from './app.config';

const i18nextOptions = {
  // debug: true,
  // saveMissing: true,
  interpolation: {
    escapeValue: false
  },
  lng: 'en',
  fallbackLng: config.fallbackLng,
  whitelist: config.languages,
  react: {
    wait: false
  }
};

if (!i18n.isInitialized) {
  i18n
    .use(initReactI18next)
    .use(Backend)
    .use(LanguageDetector)
    .init(i18nextOptions);
}

export default i18n;
