module.exports = {
  '{,packages/*/!(build)/**/}*.{md,js,jsx,ts,tsx,css,scss,yml}': ['prettier --write', 'git add'],
};
