Guide rapide — Pousser le projet sur GitHub (PowerShell)

Ces commandes sont prêtes à être collées dans PowerShell sur votre machine Windows.

1) Se placer à la racine du projet (contenant `Backend` et `urgences-frontend`):

```powershell
cd "c:\Users\dell\Documents\projet stage"
```

2) Initialiser git (si nécessaire), ajouter et committer:

```powershell
git init
git add -A
git commit -m "Initial import du projet CHU Emergency (backend + frontend)"
```

3) Lier le remote GitHub et pousser la branche `main`:

```powershell
git remote add origin https://github.com/assabbar/Stage-PFA.git
git branch -M main
git push -u origin main
```

Conseils:
- Si GitHub demande des identifiants, utilisez votre compte GitHub (ou configurez un token personnel et utilisez-le comme mot de passe pour HTTPS).
- Si le dépôt distant contient déjà du contenu et que vous voulez créer une branche au lieu d'écraser:

```powershell
git checkout -b interconsultation_Sans_episode
git push -u origin interconsultation_Sans_episode
```

---

Si vous voulez, je peux créer et ajouter un `.gitignore` adapté puis préparer un commit prêt à pousser.
