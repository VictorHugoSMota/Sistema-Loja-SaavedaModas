const TOKEN_KEY = "saavedra_token";

function salvarToken(token) {
    localStorage.setItem(TOKEN_KEY, token);
}

function buscarToken() {
    return localStorage.getItem(TOKEN_KEY);
}

function removerToken() {
    localStorage.removeItem(TOKEN_KEY);
}

function usuarioEstaLogado() {
    return buscarToken() !== null && buscarToken() !== "";
}

function logout() {
    removerToken();
    window.location.href = "/";
}

function headersAutenticados(headersExtras = {}) {
    const token = buscarToken();

    const headers = {
        "Content-Type": "application/json",
        ...headersExtras
    };

    if (token) {
        headers["Authorization"] = `Bearer ${token}`;
    }

    return headers;
}

async function apiFetch(url, options = {}) {
    const resposta = await fetch(url, {
        ...options,
        headers: headersAutenticados(options.headers || {})
    });

    if (resposta.status === 401 || resposta.status === 403) {
        removerToken();
        alert("Sua sessão expirou ou você não está autorizado. Faça login novamente.");
        window.location.href = "/";
        return;
    }

    return resposta;
}

function protegerPagina() {
    if (!usuarioEstaLogado()) {
        window.location.href = "/";
    }
}