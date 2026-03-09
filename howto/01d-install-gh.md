 do gh

1. **Adicione o repositório oficial do GitHub CLI (https://cli.github.com/)**
```bash
type -p curl >/dev/null || sudo apt install curl -y
curl -fsSL https://cli.github.com/packages/githubcli-archive-keyring.gpg | \
  sudo dd of=/usr/share/keyrings/githubcli-archive-keyring.gpg

sudo chmod go+r /usr/share/keyrings/githubcli-archive-keyring.gpg

echo "deb [arch=$(dpkg --print-architecture) \
signed-by=/usr/share/keyrings/githubcli-archive-keyring.gpg] \
https://cli.github.com/packages stable main" | \
sudo tee /etc/apt/sources.list.d/github-cli.list > /dev/null
```

2. **Atualize os pacotes**
```bash
sudo apt update
```

3. **Instale o GitHub CLI**
```bash
sudo apt install gh -y
```

4. **Verifique a instalação**
```bash
gh --version
```

5. **Autenticar**
```bash
gh auth login
```

6. **Verificar**
```bash
gh auth status
```