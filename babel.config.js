const fs = require('fs');
const path = require('path');

module.exports = {
  babelrcRoots: fs
    .readdirSync('packages')
    .map(dirname => path.join(process.cwd(), 'packages', dirname))
    .filter(dirpath => {
      const stats = fs.statSync(dirpath);

      return stats.isDirectory();
    }),
  presets: [['@babel/preset-env', { targets: { node: 'current' } }], '@babel/preset-typescript'],
  plugins: [
    '@babel/plugin-proposal-object-rest-spread',
    '@babel/plugin-proposal-class-properties',
    ['@babel/plugin-transform-typescript', { allowNamespaces: true }],
  ],
};
